package enterprise.sample.com.email_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText et_email, et_subject, et_message;

    Button b_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText) findViewById(R.id.et_email);
        et_subject = (EditText) findViewById(R.id.et_subject);
        et_message = (EditText) findViewById(R.id.et_message);

        b_send = (Button) findViewById(R.id.b_send);

        b_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String to = et_email.getText().toString();

                String subject = et_subject.getText().toString();
                String message = et_message.getText().toString();
                String aEmailCCList[] = { "user3@fakehost.com","user4@fakehost.com"};
                String aEmailBCCList[] = { "user5@fakehost.com" };

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(intent.EXTRA_TEXT, message);
                intent.setType("image/jpg");
              //  intent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<font size=\"6\">This is some text!</font> "));
                final File attachment = new File("content://media/external/images/media/30011");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(attachment));
                intent.putExtra(intent.EXTRA_CC, aEmailCCList);
                intent.putExtra(intent.EXTRA_BCC,aEmailBCCList);
                intent.putExtra(intent.EXTRA_SUBJECT,subject);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email app"));
            }


                                  }



        );

    }
}
