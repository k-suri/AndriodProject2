package ks.example.project2muskaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ks.example.project2muskaan.databinding.ActivityMapsBinding
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var latitude: TextView
    lateinit var longitude: TextView
    lateinit var latSetText: TextView
    lateinit var longSetText: TextView
    lateinit var btnwa: Button
    lateinit var latObj: LatLng

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
     * If Google Play services is n ot installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val zoomLevel = 15f

        val london = LatLng(42.9832, -81.2447) //London
        latObj = london
        map.addMarker(MarkerOptions().position(london).title("Marker in London"))
        val school = LatLng(42.98259, -81.24685)
        map.addMarker(MarkerOptions().position(school).title("School") .icon(
            BitmapDescriptorFactory.defaultMarker(
            BitmapDescriptorFactory.HUE_ROSE)))
        //map.moveCamera(CameraUpdateFactory.newLatLng(london))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(london, zoomLevel))
        setMapLongClick(map)
        setPoiClick(map)

        val belowFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? BlankFragment
       println("**************************")
        println(belowFragment)

        latitude = belowFragment?.getLatitutde()!!
        longitude = belowFragment?.getLongitude()!!
        btnwa = belowFragment?.getButton()!! as Button
        btnwa.setOnClickListener {
            setvalues()
        }
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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }
    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener { latLng ->
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )
            latObj = latLng

            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
            )
        }
    }


    private fun setPoiClick(map: GoogleMap) {
        val self = this
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

            self.latObj = poi.latLng
            poiMarker?.showInfoWindow()
        }
    }
    public fun setvalues() {
        latitude.setText(latObj.latitude.toString())
        longitude.setText(latObj.longitude.toString())
    }
}




