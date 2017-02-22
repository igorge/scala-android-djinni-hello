package gie.hello

import _root_.android.app.{Activity, Application}
import _root_.android.os.Bundle
import _root_.android.support.v7.app.AppCompatActivity
import _root_.android.graphics.drawable.Animatable
import slogging._
import android.util.Log
import gie.HelloWorldMaker


class App extends Application with LazyLogging {

    override def onCreate(): Unit ={
        super.onCreate()

        LoggerConfig.factory = SLF4JLoggerFactory//PrintLoggerFactory
        LoggerConfig.level = LogLevel.TRACE

        logger.trace("Application.onCreate()")

        System.loadLibrary("hello-jni")

    }

    val jniLogger = new _root_.gie.Logger {
        def log(value: String): Unit ={
            logger.info(s"JNI: ${value}")
        }
    }

}

class MainActivity extends AppCompatActivity {
    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        // type ascription is required due to SCL-10491
        val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)

        val ret = HelloWorldMaker.make(42, getApplication().asInstanceOf[App].jniLogger ).doHelloWorld(TR.string.app_name.value)

        vh.text.setText(s"Hello world, from ${TR.string.app_name.value}, ret: ${ret}")
        vh.image.getDrawable match {
          case a: Animatable => a.start()
          case _ => // not animatable
        }
    }
}
