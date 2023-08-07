package ks.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() ,SelectInterface{
    private val itemsList = ArrayList<FlowerData>()
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        title = "Flowers List"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        dataProvider()
    }

    private fun dataProvider(){
        itemsList.add(FlowerData("marigold","marigold foliage has a musky, pungent scent, though some varieties have\n" +
                "been bred to be scentless. It is said to deter some common insect pests,\n" +
                "as well as nematodes",13.99))
       itemsList.add(FlowerData("Dahlia","Dahlia is a genus of tuberous plants that are members of the Asteraceae\n" +
               "family, which also includes the sunflower, daisy, chrysanthemum, zinnia,\n" +
               "and, of course, aster. Dahlias are perennial plants with tuberous roots",19.99))
        itemsList.add(FlowerData("daisy","daisy, any of several species of flowering plants belonging to the aster\n" +
                "family, is a composite plant (as of the genera Bellis or Chrysanthemum)\n" +
                "having a flower head with well-developed ray flowers usually arranged in\n" +
                "one or a few whorls",12.99))
        itemsList.add(FlowerData("freesia","freesia has intoxicating scent, long vase life, and enticing array of jewel-\n" +
                "toned colors, these welcome winter bloomers are easy to force indoors\n" +
                "as inexpensive, longer-lasting alternatives to cut flowers",39.99))
        itemsList.add(FlowerData("lilac","the paste is prepared with wheat that is stone-grounded every single day,\n" +
                "the incredible \"just-ground\" pappardelle with sea urchin, cauliflower and\n" +
                "crushed chile—a plate of silky pasta with briny seafood and a hint of heat",35.99))
        itemsList.add(FlowerData("lily","large hollow pasta tubes (paccheri) are mixed with chunks of lamb,\n" +
                "tomato ragù and grated Pecorino, the dish is finished with mint With\n" +
                "colorful, star-shaped flowers, lilies give star power to summer gardens.\n" +
                "These perennial beauties need a bit of extra fall care in areas where\n" +
                "winters are harsh",15.99))
        itemsList.add(FlowerData("peony","The peony is outrageously beautiful in bloom with the fattest, most\n" +
                "scrumptious flowers and lush green foliage. Peonies are perennials that\n" +
                "come back every year to take your breath away. In fact, the plants may\n" +
                "live longer than you do—some have been known to thrive for at least 100\n" +
                "years",39.99))
        itemsList.add(FlowerData("rose","Roses are a popular crop for both domestic and commercial cut flowers.\n" +
                "Generally they are harvested and cut when in bud, and held in\n" +
                "refrigerated conditions until ready for display at their point of sale.",29.99))
        itemsList.add(FlowerData("sunflower","With bright blooms that go all summer, sunflowers are heat-tolerant,\n" +
                "resistant to pests, and attractive to pollinators and birds. They make\n" +
                "beautiful cut flowers and their seeds (and oil) are a source of food for\n" +
                "birds and people.",22.95))
        itemsList.add(FlowerData("tulip","Tulips (Tulipa) are a genus of spring-blooming perennial herbaceous\n" +
                "bulbiferous geophytes (having bulbs as storage organs). The flowers are\n" +
                "usually large, showy and brightly coloured, generally red, pink, yellow, or\n" +
                "white (usually in warm colours)",29.99))

        customAdapter.notifyDataSetChanged()
    }

    override fun onItemClicked(flowerData: FlowerData?) {
        val bundle = Bundle()
        bundle.putString("name",flowerData?.name)
        bundle.putString("desc",flowerData?.description)
        if (flowerData != null) {
            bundle.putDouble("price",flowerData.price)
        }
        val intent = Intent(this,FlowerActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}