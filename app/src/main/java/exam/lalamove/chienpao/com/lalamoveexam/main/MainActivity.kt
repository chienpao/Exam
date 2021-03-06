package exam.lalamove.chienpao.com.lalamoveexam.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import exam.lalamove.chienpao.com.lalamoveexam.MainApplication
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import exam.lalamove.chienpao.com.lalamoveexam.detail.DetailActivity
import exam.lalamove.chienpao.com.lalamoveexam.main.adapter.DeliveryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject
import android.support.v4.app.NotificationCompat.getExtras



class MainActivity : AppCompatActivity(), DeliveryAdapter.Callback {

    lateinit var mainModule: MainModule
    lateinit var mainComponent: MainComponent

    @Inject lateinit var presenter: MainPresenter
    lateinit var deliveryAdapter: DeliveryAdapter

    companion object {
        private const val DEFAULT_OFFSET = 0
        private const val DEFAULT_LIMIT = 20
        const val DELIVERY_KEY = "delivery"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInjections()
        setSupportActionBar(toolbar)
        toolbarTitle.text = getString(R.string.main_title)
        title = ""
        bindViews()
        presenter.getDeliveries(DEFAULT_OFFSET, DEFAULT_LIMIT)
    }

    private fun bindViews() {
        deliveryAdapter = DeliveryAdapter(this)
        recyclerView.adapter = deliveryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = null
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClick(deliver: Deliver) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DELIVERY_KEY, deliver)
        startActivity(intent)
    }

    override fun onLoadItem(lastId: Int) {
        presenter.getDeliveries(lastId, DEFAULT_LIMIT)
    }

    fun showMessageOnSnackBar(errorMessage: String) {
        Snackbar.make(rootLayout, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    fun updateDeliveries(deliveries: ArrayList<Deliver>?) {
        if (deliveries != null) {
            deliveryAdapter.append(deliveries)
        }
    }

    private fun initInjections() {
        mainModule = MainModule(this)
        mainComponent = DaggerMainComponent.builder()
                .mainModule(mainModule)
                .appComponent((application as MainApplication).appComponent)
                .build().apply {
                    inject(this@MainActivity)
                }
    }
}
