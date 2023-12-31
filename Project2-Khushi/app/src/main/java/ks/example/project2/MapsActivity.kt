package ks.example.project2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ks.example.project2.databinding.ActivityMapsBinding
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var latLngObj: LatLng
    lateinit var latTextView: TextView
    lateinit var lonTextView: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val zoomLevel = 15f
        // Add a marker in Sydney and move the camera
        val london = LatLng(42.9849233, -81.245276) //London
        val HappinessCoffeeStore = LatLng(42.985710388, -81.245367676) //London
        latLngObj = london
        map.addMarker(MarkerOptions().position(london).title("London Lat:42.9849233 Lon:-81.245276"))
        map.addMarker(MarkerOptions().position(HappinessCoffeeStore).title("Happiness Coffee Store")
            .icon(BitmapDescriptorFactory.defaultMarker(
            BitmapDescriptorFactory.HUE_VIOLET)))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(london, zoomLevel))
        setPoiClick(map)
        setMapLongClick(map)

        val bottomFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? Fragment
        latTextView = bottomFragment?.getLatTextView()!!
        lonTextView = bottomFragment?.getLonTextView()!!
        button = bottomFragment?.getButton() as Button
        button.setOnClickListener{
            setLatLongTextFeilds()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    private fun setPoiClick(map: GoogleMap){
        map.setOnPoiClickListener { poi ->
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                poi.latLng.latitude,
                poi.latLng.longitude
            )
            val poiMarker = map.addMarker(
                MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)
                    .snippet(snippet)
            )
            latLngObj = poi.latLng
            poiMarker?.showInfoWindow()
        }
    }

    private fun setMapLongClick(map:GoogleMap){

        map.setOnMapLongClickListener { latLng ->
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )
            latLngObj= latLng
            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
            )
        }
    }

    public fun setLatLongTextFeilds(){
        latTextView.setText(latLngObj.latitude.toString())
        lonTextView.setText(latLngObj.longitude.toString())
    }
}