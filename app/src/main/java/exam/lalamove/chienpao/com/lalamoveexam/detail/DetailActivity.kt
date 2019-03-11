package exam.lalamove.chienpao.com.lalamoveexam.detail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import exam.lalamove.chienpao.com.lalamoveexam.MainApplication
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import exam.lalamove.chienpao.com.lalamoveexam.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.viewholder_delivery_item.*

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var detailModule: DetailModule
    lateinit var detailComponent: DetailComponent
    lateinit var currentDeliver: Deliver

    companion object {
        private const val DEFAULT_ZOOM_LEVEL = 10f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initInjections()
        setSupportActionBar(toolbar)

        updateUI(intent)
    }

    private fun updateUI(intent: Intent) {
        currentDeliver = intent.getParcelableExtra(MainActivity.DELIVERY_KEY) as Deliver
        location.text = currentDeliver.location.toString()

        description.text = currentDeliver.description
        Glide.with(this).load(currentDeliver.imageUrl).centerCrop().into(image)
    }

    private fun initInjections() {
        detailModule = DetailModule(this)
        detailComponent = DaggerDetailComponent.builder()
                .detailModule(detailModule)
                .appComponent((application as MainApplication).appComponent)
                .build().apply {
                    inject(this@DetailActivity)
                }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val deliverLocation = LatLng(currentDeliver.location.lat, currentDeliver.location.lng)

        googleMap ?: return
        with(googleMap) {
            moveCamera(CameraUpdateFactory.newLatLngZoom(deliverLocation, DEFAULT_ZOOM_LEVEL))
            addMarker(MarkerOptions().position(deliverLocation))
        }
    }
}
