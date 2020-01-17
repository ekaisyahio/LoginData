package cusersrpl2016_22nventari.logindata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username = findViewById(R.id.txt_username);
        final EditText password = findViewById(R.id.txt_password);
        Button Login = findViewById(R.id.btnlogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.post("http://192.168.6.248/eka/insertdata.php")
                        .addBodyParameter("username", "admin")
                        .addBodyParameter("password", "admin123")
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean respon  = hasil.getBoolean("respon");
                                    if (respon) {
                                        Toast.makeText(getApplicationContext(), "sukses daftar", Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(getApplicationContext(), "server error", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
