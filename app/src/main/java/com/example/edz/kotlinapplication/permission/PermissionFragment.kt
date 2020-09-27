package com.bixin.bixingaigai.permission

import android.content.pm.PackageManager;
import android.os.Build
import android.os.Bundle;
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment;


open class PermissionFragment : Fragment() {

    private var mPermissionsCallback: PermissionsCallback? = null;

    interface PermissionsCallback {
        fun onResult(list: ArrayList<PermissionResult>);
    }

    companion object {
        private var PERMISSIONS_REQUEST_CODE = 42;
        private var TAG = "PermissionFragment";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true);
    }

    fun requestPermissions(permissions: Array<String>, permissionsCallback: PermissionsCallback) {
        this.mPermissionsCallback = permissionsCallback;
        requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
    }

    /**
     * 请求返回结果
     * @param requestCode Int 请求码
     * @param permissions Array<String> 权限
     * @param grantResults IntArray 请求结果
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            val permissionResultList = ArrayList<PermissionResult>();
            var length = permissions.size;
            for (i in 0 until length) {
                val permission = PermissionResult(
                    permissions[i], grantResults[i] === 0,
                    shouldShowRequestPermissionRationale(permissions[i]))
                permissionResultList.add(permission)
            }
            val permissionsCallback = this.mPermissionsCallback
            permissionsCallback?.onResult(permissionResultList)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isGranted(permission: String): Boolean {
        val fragmentActivity = activity
        if (fragmentActivity != null) {
            return fragmentActivity.checkSelfPermission(permission) == 0;
        }
        return false;
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isRevoked(permission: String): Boolean {
        val fragmentActivity = activity
        if(fragmentActivity != null){
            var  packageManager: PackageManager = fragmentActivity.packageManager
            if ((fragmentActivity != null) && (packageManager  != null)) {
                return packageManager.isPermissionRevokedByPolicy(
                    permission, fragmentActivity.packageName)
            }
        }
        return false;
    }






}