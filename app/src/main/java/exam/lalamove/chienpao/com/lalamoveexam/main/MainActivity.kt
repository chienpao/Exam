package exam.lalamove.chienpao.com.lalamoveexam.main

import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import exam.lalamove.chienpao.com.lalamoveexam.MainApplication
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import exam.lalamove.chienpao.com.lalamoveexam.main.adapter.DeliveryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DeliveryAdapter.Callback {

    lateinit var mainModule: MainModule
    lateinit var mainComponent: MainComponent

    @Inject lateinit var presenter: MainPresenter
    lateinit var deliveryAdapter: DeliveryAdapter

    companion object {
        private const val DEFAULT_OFFSET = 0
        private const val DEFAULT_LIMIT = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInjections()
        setSupportActionBar(toolbar)
        title = getString(R.string.main_title)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(deliver: Deliver) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
