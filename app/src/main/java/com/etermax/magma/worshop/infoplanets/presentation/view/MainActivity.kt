package com.etermax.magma.worshop.infoplanets.presentation.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.etermax.magma.worshop.R
import com.etermax.magma.worshop.infoplanets.context.InfoPlanetContextFactory.Companion.infoPlanetApiClient
import com.etermax.magma.worshop.infoplanets.core.action.FindPlanet
import com.etermax.magma.worshop.infoplanets.infrastructure.ApiPlanetsRepository
import com.etermax.magma.worshop.infoplanets.presentation.presenter.InfoPlanetReducedDataModel
import com.etermax.magma.worshop.infoplanets.presentation.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var findButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var orbitalDaysTextView: TextView
    private lateinit var rotationDaysTextView: TextView
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = createPresenter()
        findButton = findViewById(R.id.findButton)
        nameTextView = findViewById(R.id.namePlanetTextView)
        orbitalDaysTextView = findViewById(R.id.orbitalDaysTextVIew)
        rotationDaysTextView = findViewById(R.id.rotationDayTextView)
        findButton.setOnClickListener { mainPresenter.findInfoPlanet() }
        initFields()
    }

    private fun initFields() {
        nameTextView.text = resources.getString(R.string.name).format("")
        orbitalDaysTextView.text =
                resources.getString(R.string.orbital_days).format("")
        rotationDaysTextView.text =
                resources.getString(R.string.rotation_days).format("")
    }

    private fun createPresenter(): MainPresenter {
        val apiPlanetsRepository = ApiPlanetsRepository(infoPlanetApiClient())
        return MainPresenter(this, FindPlanet(apiPlanetsRepository))
    }

    override fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showInfoPlanet(infoPlanetReducedDataModel: InfoPlanetReducedDataModel) {
        nameTextView.text = resources.getString(R.string.name).format(infoPlanetReducedDataModel.name)
        orbitalDaysTextView.text =
                resources.getString(R.string.orbital_days).format(infoPlanetReducedDataModel.orbitalDays)
        rotationDaysTextView.text =
                resources.getString(R.string.rotation_days).format(infoPlanetReducedDataModel.rotationDays)
    }
}