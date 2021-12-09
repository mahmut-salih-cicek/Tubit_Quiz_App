package com.xmod.quiz_app_example_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {


    var soruText : String? = null
    var zamanText : String? = null
    var arraySoru = ArrayList<ModelSoru>()
    var sourIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        /// theme
        supportActionBar?.hide()
        // soruyu arrayliste ekledik
        arraySoru.add(ModelSoru("2017 de Google Android\nHangi Dile geçmiştir?","java","Go","Kotlin"))
        arraySoru.add(ModelSoru("Flutter v2 ne zaman gecti","2000","2019","2021"))
        arraySoru.add(ModelSoru("2021 Android son surumu nedir","12","14","10"))


        // ilk soru gösterildi
        soruDegistir(sourIndex)

        // zamanlayıcı olusturuldu
        var countDownTimer = object : CountDownTimer(10000,1000){

            override fun onTick(millisUntilFinished: Long) {
                zamanText = (millisUntilFinished.toInt()/1000).toString()
                zaman.text = "Zaman: $zamanText"
            }

            override fun onFinish() {
                val intent = Intent(this@QuizActivity,UserActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        countDownTimer.start()



    }

    fun a_button(view:View){
      if (sourIndex == 0){
          hatalıCevap()
      }else if (sourIndex == 1){
          hatalıCevap()
      }else if (sourIndex == 2){
          var intent = Intent(this,UserActivity::class.java)
          startActivity(intent)
          finish()
      }
    }

    fun b_button(view: View) {
        if (sourIndex == 0){
            hatalıCevap()
        }else if(sourIndex == 1){
            sourIndex = sourIndex + 1
            soruDegistir(sourIndex)
        }else if (sourIndex == 2){
            hatalıCevap()
        }
    }

    fun c_button(view: View) {
        if (sourIndex == 0){
            sourIndex = sourIndex + 1
            soruDegistir(sourIndex)
        }else if (sourIndex == 1){
            hatalıCevap()
        }else if (sourIndex == 2){
            hatalıCevap()
        }
    }


    fun soruDegistir(sourIndex:Int){
        soruText = arraySoru[sourIndex].soru
        sorular.text = soruText
        // soru değiştiğinde şıklarda değişsin
        cevapAbutton.text = arraySoru[sourIndex].cevapA
        cevapBbutton.text = arraySoru[sourIndex].cevapB
        cevapCbutton.text = arraySoru[sourIndex].cevapC
    }



    fun hatalıCevap(){
        var alerDialog = AlertDialog.Builder(this)
        alerDialog.setMessage("Hatalı cevap")
        alerDialog.show()
    }





}