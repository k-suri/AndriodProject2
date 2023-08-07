package ks.example.project1_sem3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ks.example.project1_sem3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = Bundle();
        val intent = Intent(this, DetailsActivity::class.java)
        binding.artBtn.setOnClickListener {
            bundle.putString("type","arts");
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.autoBtn.setOnClickListener {
            bundle.putString("type","automobiles");
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.bookBtn.setOnClickListener {
            bundle.putString("type","booksreview")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.fashionBtn.setOnClickListener {
            bundle.putString("type","fashion")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.foodBtn.setOnClickListener {
            bundle.putString("type","food")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.healthBtn.setOnClickListener {
            bundle.putString("type","health")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.politicsBtn.setOnClickListener {
            bundle.putString("type","health")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.sportsBtn.setOnClickListener {
            bundle.putString("type","sports")
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.businessBtn.setOnClickListener {
            bundle.putString("type","business")
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}