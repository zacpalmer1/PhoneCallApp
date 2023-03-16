package edu.cofc.andriod.phonecall2

import android.content.Intent
import android.Manifest;
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import edu.cofc.andriod.phonecall2.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var builder = StringBuilder(13).append('(')


    private val requestPermissionLauncher : ActivityResultLauncher<String>
            = registerForActivityResult(
        ActivityResultContracts.
    RequestPermission()) {
            isGranted: Boolean ->
        if (isGranted) {
            makeCall()
        }
        else {
            AlertDialog.Builder(this)
                .setTitle(R.string.permission_denied_title)
                .setMessage(R.string.permission_denied_msg)
                .setNegativeButton(R.string.ok) {
                        dialog, _ -> dialog.cancel()
                }
                .show()
        }
    }
    private fun checkPhonePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
            == PackageManager.PERMISSION_GRANTED) {
            makeCall()
        }
        else if (shouldShowRequestPermissionRationale(
                Manifest.permission.CALL_PHONE)) {
            AlertDialog.Builder(this)
                .setTitle(R.string.permission_request_title)
                .setMessage(R.string.permission_request_msg)
                .setPositiveButton(R.string.yes) { _, _ ->
                    requestPermissionLauncher.launch(
                        Manifest.permission.CALL_PHONE)}
                .setNegativeButton(R.string.no) { _, _ -> }
                .show()
        }
        else {
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }
    private fun makeCall() {
        try {
            val phoneNumToCall : String
                    = binding.output.text.toString()
            val uri = Uri.parse("tel:$phoneNumToCall")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
        catch (ex: SecurityException) {
            val logTag = "MainActivity.makeCall()"
            val errorMsg = "No permission to make phone call."
            Log.e(logTag, errorMsg, ex)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setBackgroundColor(Color.parseColor("#000000"))

        binding.one.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('1')
            binding.output.text = builder
        }
        binding.two.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('2')
            binding.output.text = builder
        }
        binding.three.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('3')
            binding.output.text = builder
        }
        binding.four.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('4')
            binding.output.text = builder
        }
        binding.five.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('5')
            binding.output.text = builder
        }
        binding.six.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('6')
            binding.output.text = builder
        }
        binding.seven.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('7')
            binding.output.text = builder
        }
        binding.eight.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('8')
            binding.output.text = builder
        }
        binding.nine.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('9')
            binding.output.text = builder
        }
        binding.star.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('*')
            binding.output.text = builder
        }
        binding.zero.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('0')
            binding.output.text = builder
        }
        binding.hash.setOnClickListener{
            if (builder.length == 4){
                builder.append(") ")
            }
            else if (builder.length == 9){
                builder.append('-')
            }
            builder.append('#')
            binding.output.text = builder
        }
        binding.back.setOnClickListener{
            builder.deleteCharAt(builder.length-1)
            binding.output.text = builder
        }
        binding.clear.setOnClickListener{
            builder.delete(0, builder.length)
            binding.output.text = builder
            builder.append('(')
        }
        binding.call.setOnClickListener {
            checkPhonePermission()
        }
    }
}