package com.bixin.bixingaigai.permission

import android.os.Build
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import java.util.*
import kotlin.collections.ArrayList

open class PermissionHelper {

    interface OnPermissionListener {
        fun onDenied();
        fun onGranted();
    }

    companion object {
        private var TAG_PermissionFragment = "PermissionFragment";

        fun requestPermissions(
            activity: FragmentActivity,
            listener: OnPermissionListener,
            vararg permissions: String) {
            val supportFragmentManager = activity.supportFragmentManager
            requestPermissions(
                supportFragmentManager,
                listener,
                *Arrays.copyOf(permissions, permissions.size) as Array<String>
            )
        }

        fun requestPermissions(
            fragment: Fragment,
            listener: OnPermissionListener,
            vararg permissions: String) {
            val childFragmentManager = fragment.childFragmentManager
            requestPermissions(
                childFragmentManager,
                listener,
                *Arrays.copyOf(permissions, permissions.size) as Array<String>
            )
        }

        fun requestPermissions(
            fragmentManager: FragmentManager,
            listener: OnPermissionListener,
            vararg permissions: String) {
            val permissionFragment = getPermissionFragment(fragmentManager)
            var needRequestPermissions = ArrayList<String>()
            for (permission in permissions) {
                if (!isGranted(permissionFragment, permission)
                    && !isRevoked(permissionFragment, permission)) {
                    needRequestPermissions.add(permission)
                }
            }
            if (needRequestPermissions.isEmpty()) {
                listener.onGranted()
                return
            }
            val array = needRequestPermissions.toTypedArray()
            if (array != null) {
                // 重点 转换
                // permissionFragment.requestPermissions((String[]) array, new PermissionHelper$Companion$requestPermissions$1(listener));
                permissionFragment.requestPermissions(array, PermissionHelperRequestPermissions(listener))
            }

        }


        private fun isGranted(permissionFragment: PermissionFragment, permission: String): Boolean {
            return !isMarshMallow() || permissionFragment.isGranted(permission)
        }

        private fun isRevoked(permissionFragment: PermissionFragment, permission: String): Boolean {
            return isMarshMallow() && permissionFragment.isRevoked(permission)
        }

        private fun isMarshMallow(): Boolean {
            return Build.VERSION.SDK_INT >= 23
        }

        private fun getPermissionFragment(fragmentManager: FragmentManager): PermissionFragment {
            val permissionFragment = findPermissionFragment(fragmentManager)
            if (permissionFragment != null) {
                return permissionFragment
            }
            var permissionFragment2 = PermissionFragment()
            fragmentManager.beginTransaction()
                .add(permissionFragment2 ,TAG_PermissionFragment)
                .commitNow()
            return permissionFragment2
        }

        private fun findPermissionFragment(fragmentManager: FragmentManager): PermissionFragment? {
            var findFragmentByTag = fragmentManager.findFragmentByTag(TAG_PermissionFragment)
            if (findFragmentByTag !is PermissionFragment) {
                findFragmentByTag = null
                return null;
            }
            return findFragmentByTag as PermissionFragment
        }
    }



}

open class PermissionHelperRequestPermissions constructor(val listener: PermissionHelper.OnPermissionListener) :PermissionFragment.PermissionsCallback{

    override fun onResult(permissionResultList: ArrayList<PermissionResult>) {
        for (permissionResult in permissionResultList) {
            if (!permissionResult.granted) {
                listener.onDenied()
                return
            }
        }
        listener.onGranted()
    }
}
