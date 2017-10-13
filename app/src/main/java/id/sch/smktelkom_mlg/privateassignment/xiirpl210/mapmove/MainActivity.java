package id.sch.smktelkom_mlg.privateassignment.xiirpl210.mapmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition IND = CameraPosition.builder()
            .target(new LatLng(0.7893, 113.9213))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition TULUNGAGUNG = CameraPosition.builder()
            .target(new LatLng(8.0912, 111.9642))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition NGAWI = CameraPosition.builder()
            .target(new LatLng(7.4610, 111.3322))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition BANDUNG = CameraPosition.builder()
            .target(new LatLng(6.9175, 107.6191))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTulungagung = (Button) findViewById(R.id.btnTulungagung);
        btnTulungagung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(TULUNGAGUNG);
            }
        });

        Button btnNgawi = (Button) findViewById(R.id.btnNgawi);
        btnNgawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(NGAWI);
            }
        });

        Button btnBandung = (Button) findViewById(R.id.btnBandung);
        btnBandung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(BANDUNG);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(IND);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
