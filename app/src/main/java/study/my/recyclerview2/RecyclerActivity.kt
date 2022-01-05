package study.my.recyclerview2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerActivity: AppCompatActivity() {
    private lateinit var cars: MutableList<Car>
    private var carsAdapter: CarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        cars = generateCarList()

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        carsAdapter = CarAdapter(cars, object: CarAdapter.CarClickListener {
            override fun onCarClick(car: Car?) {
                Toast.makeText(this@RecyclerActivity, car?.manufacturer, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = carsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }

    private fun generateCarList(): MutableList<Car> {
        val list = mutableListOf<Car>()

        for (i in 0..10) {
            list.add(generateCar(i))
        }
        return list
    }

    private fun generateCar(int: Int): Car {
        return Car("bmw $int", "m4 $int")
    }

}