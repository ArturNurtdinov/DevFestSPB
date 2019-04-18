package com.example.devfestspb


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.devfestspb.fakeList.RecyclerActivity
import com.example.devfestspb.report.Report
import com.example.devfestspb.report.ReportActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reportOfArturVasilov = Report(
            id = 1,
            title = "Как мы ускоряем Яндекс под Android",
            author = "Артур Василов ",
            tag = "Android",
            rep = "Многие Android-разработчики знают стандартные методы профилирования приложений, " +
                    "инструменты для отладки и улучшения производительности." +
                    " Однако для случая больших приложений этого не всегда достаточно." +
                    " Мы поговорим о нестандартных способах ускорения работы приложения," +
                    " затронем самые разные аспекты, как вопросы UI," +
                    " так и инструментов и околосерверных вещей. Я надеюсь, что этот доклад заставит вас посмотреть" +
                    " на вопросы производительности по-новому и подумать о том, что вы можете сделать в своем приложении."
        )

        val reportOfKonstantinTskhovrebov = Report(
            id = 2,
            title = "Нашёл. Увидел. Запилил",
            author = "Константин Цховребов",
            tag = "Android",
            rep = "Я был впечатлен представленным Google IO Motion Layout," +
                    " поэтому решил изучить его в бою и рассказать о практическом использовании вам." +
                    " Я пошел на Dribbble.com и выбрал понравившуюся анимацию." +
                    " Теперь я сделаю все, чтобы реализовать ее, используя MotionLayout, и расскажу о фичах и проблемах аудитории."
        )

        val reportOfEvgenyShishkin = Report(
            id = 3,
            title = "Aviasales Отели - практический опыт объединения двух приложений",
            author = "Евгений Шишкин",
            tag = "Android",
            rep = "До недавнего времени у нас независимо существовало два приложения: " +
                    "Aviasales — метапоиск авиабилетов и Hotellook — метапоиск отелей/хостелов/аппартов." +
                    " И все было хорошо, пока не появилась задача интегрировать возможность поиска и бронирования отелей в приложение Aviasales," +
                    " для того чтобы увеличить конверсию пользователей в отельную часть и зарабатывать еще больше денег \uD83D\uDE01" +
                    " Так как Aviasales и Hotellook — это совершенно разные проекты с разными командами," +
                    " разными архитектурными подходами, задача эта оказалась весьма непростой и интересной. Спойлер:" +
                    " В результате объединения приложения свет увидели 2 любопытные open source библиотеки: mrButler и nautilus."
        )

        val reportOfIlyaKlymov = Report(
            id = 4,
            title = "Большое А: от любви к ненависти и обратно",
            author = "Илья Климов",
            tag = "Frontend",
            rep = "Всем привет. Меня зовут Илья и я пишу на JavaScript уже более 10 лет." +
                    " За это время я перепробовал почти все хайповые и парочку маргинальных фреймворков," +
                    " но сейчас остановил свой выбор и выбор моей компании на Vue и React." +
                    " Больше 3 лет со сцен и в кулуарах многих митапов и конференций я рассказывал, почему не Angular," +
                    " делился своей болью и опытом, критиковал, подшучивал и иронизировал. Этот доклад - рассказ про то, как вышло так," +
                    " что сейчас я на полном серьезе рекомендую Angular как лучшую технологическую платформу большинству своих коллег."
        )

        val txtv1 = findViewById<TextView>(R.id.artur_vasilov_menu)
        txtv1.setOnClickListener { openSecondActivity(reportOfArturVasilov) }

        val txtv2 = findViewById<TextView>(R.id.konstantin_tskhovrebov_menu)
        txtv2.setOnClickListener { openSecondActivity(reportOfKonstantinTskhovrebov) }

        val txtv3 = findViewById<TextView>(R.id.evgeniy_shishkin_menu)
        txtv3.setOnClickListener { openSecondActivity(reportOfEvgenyShishkin) }

        val txtv4 = findViewById<TextView>(R.id.ilya_klimov_menu)
        txtv4.setOnClickListener { openSecondActivity(reportOfIlyaKlymov) }

        val tvAboutAuthors = findViewById<TextView>(R.id.about_author_text_view)
        tvAboutAuthors.setOnClickListener { openAboutAuthorsActivity() }
    }

    private fun openSecondActivity(report: Report) {
        val intent = Intent(this, ReportActivity::class.java)
        intent.putExtra(ReportActivity.AUTHOR_KEY, report.author)
        intent.putExtra(ReportActivity.TAG_KEY, report.tag)
        intent.putExtra(ReportActivity.REPORT_KEY, report.rep)
        intent.putExtra(ReportActivity.TITLE_KEY, report.title)
        startActivity(intent)
    }

    private fun openAboutAuthorsActivity() {
        val intent = Intent(this, AboutAuthorsActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.fake_mail_menu_item -> openRecyclerActivity()
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun openRecyclerActivity() {
        val intent = Intent(this, RecyclerActivity::class.java)
        startActivity(intent)
    }

}