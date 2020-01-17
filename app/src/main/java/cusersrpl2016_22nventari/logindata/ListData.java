package cusersrpl2016_22nventari.logindata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.logindata.Adapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;

public class ListData extends AppCompatActivity {
    RecyclerView recyclerView;
    private com.example.logindata.Adapter adapter;
    private ArrayList<Siswa> rvData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        initDataset();

       recyclerView = findViewById(R.id.recyclerview);

       adapter = new Adapter(rvData);


       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(adapter);
    }
    private void initDataset(){


        Siswa siswa1 = new Siswa();
        siswa1.setNama("Aslichah");
        siswa1.setKelas("12");
        siswa1.setAlamat("Jurang");
        rvData.add(siswa1);

        Siswa siswa2 = new Siswa();
        siswa1.setNama("Isna");
        siswa1.setKelas("12");
        siswa1.setAlamat("Jepara");
        rvData.add(siswa2);

        Siswa siswa3 = new Siswa();
        siswa1.setNama("Naela");
        siswa1.setKelas("12");
        siswa1.setAlamat("Kedungsari");
        rvData.add(siswa3);
    }
}