package jp.riken.mirt.splash

import edu.ucdavis.fiehnlab.spectra.hash.core
import jp.riken.mirt.splash.JavaConversions._
import scala.jdk.CollectionConverters._

trait Spectrum extends core.Spectrum {
  lazy val splashIt: String = { 
    val ions: Seq[Ion] = getIons().asScala.map(ion => Ion(ion.getMass, ion.getIntensity)).toSeq
    SplashFactory.create().splashIt(ions)
  }
}

