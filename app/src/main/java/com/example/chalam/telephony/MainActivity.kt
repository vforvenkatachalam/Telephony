package com.example.chalam.telephony

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendsms.setOnClickListener({
            var sms:SmsManager = SmsManager.getDefault()
            sms.sendTextMessage(mobile.text.toString(),null,textmessage.text.toString(),null,null)
        })
        call.setOnClickListener({
            Toast.makeText(this,"Call..",Toast.LENGTH_LONG).show();
            var i = Intent()
            i.setAction(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+mobile.text.toString()))
            startActivity(i)
        })
        attach.setOnClickListener({
            var i = Intent()
            i.setAction(Intent.ACTION_GET_CONTENT)
            i.setType("*/*")
            startActivityForResult(i,1,null)
        })
        sendmail.setOnClickListener({
            var i=Intent()
            i.setAction(Intent.ACTION_SEND)
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(email.text.toString()))
            i.putExtra(Intent.EXTRA_SUBJECT,subject.text.toString())
            i.putExtra(Intent.EXTRA_TEXT,emailmessage.text.toString())
            i.setType("text/plain")
            startActivity(i)
        })


    }
}
