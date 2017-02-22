scalaVersion := "2.11.8"

enablePlugins(AndroidApp)
android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

instrumentTestRunner :=
  "android.support.test.runner.AndroidJUnitRunner"

platformTarget := "android-25"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

libraryDependencies ++=
  "com.android.support" % "appcompat-v7" % "25.1.1" ::
  "com.android.support.test" % "runner" % "0.5" % "androidTest" ::
  "com.android.support.test.espresso" % "espresso-core" % "2.2.2" % "androidTest" ::
  Nil

libraryDependencies ++= {
    val sloggingV = "0.5.2"
    Seq(
        //"org.slf4j" % "slf4j-android" % "1.7.21",
        "biz.enef" %% "slogging" % sloggingV,
        "biz.enef" %% "slogging-slf4j" % sloggingV
    )
}


proguardOptions in Android ++= Seq(
    "-keep class gie.** {*;}"
)
