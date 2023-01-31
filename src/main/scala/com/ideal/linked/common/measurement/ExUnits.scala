/*
 * Copyright 2021 Linked Ideal LLC.[https://linked-ideal.com/]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ideal.linked.common.measurement

import tech.units.indriya.function.{MultiplyConverter, RationalConverter}
import tech.units.indriya.unit.{BaseUnit, TransformedUnit, Units}

import javax.measure.{MetricPrefix, Quantity, Unit}
import javax.measure.quantity.{Area, Length, MagneticFluxDensity, Mass, Temperature, Volume}
import java.util.Locale
/*
Extended definition of unit representation using Units of Measurement API
ref. JSR 363
 */
object ExUnits {

  final val GRAM: Unit[Mass]= new TransformedUnit[Mass]("ｇ", "GRAM", Units.GRAM, MultiplyConverter.of(1))
  final val GRAIN: Unit[Mass] = new TransformedUnit[Mass]("ｇｒ", "GRAIN", MetricPrefix.MILLI(Units.GRAM), MultiplyConverter.of(0.06479891))
  final val DRUM: Unit[Mass] = new TransformedUnit[Mass]( "ｄｒ","DRUM", Units.GRAM, MultiplyConverter.of(1.7718451953125))
  final val OUNCE: Unit[Mass] = new TransformedUnit[Mass]( "ｏｚ", "OUNCE", DRUM, MultiplyConverter.ofRational(16, 1))
  final val POUND: Unit[Mass] = new TransformedUnit[Mass]("ｌｂ", "POUND", OUNCE, MultiplyConverter.ofRational(16, 1))
  final val STONE: Unit[Mass] = new TransformedUnit[Mass]("ｓｔ", "STONE", POUND, MultiplyConverter.ofRational(14, 1))
  final val TONNE: Unit[Mass] = new TransformedUnit[Mass]("ｔ", "TONNE", Units.KILOGRAM, MultiplyConverter.ofRational(1000, 1))

  final val INCH: Unit[Length] = new TransformedUnit[Length] ("ｉｎ", "INCH", MetricPrefix.MILLI(Units.METRE) , MultiplyConverter.of(25.4))
  final val FEET: Unit[Length] = new TransformedUnit[Length] ("ｆｔ", "FEET", INCH, MultiplyConverter.ofRational(16, 1))
  final val YARD: Unit[Length] = new TransformedUnit[Length] ("ｙｄ", "YARD", FEET , MultiplyConverter.ofRational(3, 1))
  final val MILE: Unit[Length] = new TransformedUnit[Length] ("ｍｉｌｅ", "MILE",YARD , MultiplyConverter.ofRational(1760, 1))
  final val ANGSTROEM:Unit[Length] = new TransformedUnit[Length] ("\u212B","ANGSTROEM", Units.METRE, MultiplyConverter.ofRational(1, this.pow(10, 10)))

  final val SQUARE_METRE: Unit[Area] = new TransformedUnit[Area]("ｍ\u00B2", "SQUARE_METRE", Units.SQUARE_METRE , MultiplyConverter.of(1))
  final val ARE: Unit[Area] = new TransformedUnit[Area]("ａ", "ARE", Units.SQUARE_METRE , MultiplyConverter.ofRational(100, 1))
  final val HECTARE: Unit[Area] = new TransformedUnit[Area]("ｈａ", "HECTARE", Units.SQUARE_METRE , MultiplyConverter.ofRational(10000, 1))
  final val ACRE: Unit[Area] = new TransformedUnit[Area]("ａｃ", "ACRE", Units.SQUARE_METRE , MultiplyConverter.of(4046.8564224))
  final val HEIBEI: Unit[Area] = new TransformedUnit[Area]("ｍ\u00B2", "HEIBEI", Units.SQUARE_METRE , MultiplyConverter.ofRational(1, 1))
  final val TSUBO: Unit[Area] = new TransformedUnit[Area]("坪", "TSUBO", Units.SQUARE_METRE, MultiplyConverter.of(1.0/0.3025))

  final val CUBIC_METRE: Unit[Volume] = new TransformedUnit[Volume]("\u33A5", "CUBIC_METRE", Units.CUBIC_METRE , MultiplyConverter.of(1))
  final val GALLON: Unit[Volume] = new TransformedUnit[Volume]("ｇａｌ", "GALLON", Units.LITRE , MultiplyConverter.of(3.785412))
  final val QUART: Unit[Volume] = new TransformedUnit[Volume]("ｑｔ", "QUART", GALLON , MultiplyConverter.of(0.25))
  final val PINT: Unit[Volume] = new TransformedUnit[Volume]("ｐｔ", "PINT", GALLON , MultiplyConverter.of(0.5))
  final val BARREL: Unit[Volume] = new TransformedUnit[Volume]("ｂｂｌ", "BARREL" ,Units.LITRE , MultiplyConverter.of(158.9873)) //原油価格のバレルを採用

  final val GAUSS: Unit[MagneticFluxDensity] = new TransformedUnit[MagneticFluxDensity]("Ｇ", "GAUSS", Units.TESLA , MultiplyConverter.of(0.0001))

  //Implement of Name And Symbol
  //final val FAHRENHEIT: Unit[Temperature] = Units.KELVIN.multiply(5).divide(9).shift(459.67)

  trait Information extends Quantity[Information] {}
  final val BIT: Unit[Information]= new BaseUnit[Information]("ｂ", "BIT")
  final val BYTE: Unit[Information] =  new TransformedUnit[Information]("Ｂ", "BYTE", BIT , MultiplyConverter.of(8))

  trait Currency extends Quantity[Currency] {}
  final val YEN: Unit[Currency]= new BaseUnit[Currency](getCurrencySymbol(Locale.JAPAN), "YEN")
  final val DOLLER: Unit[Currency]= new BaseUnit[Currency](getCurrencySymbol(Locale.US), "DOLLAR")
  final val EURO: Unit[Currency]= new BaseUnit[Currency](getCurrencySymbol(Locale.FRANCE), "EURO")

  def getCurrencySymbol(locale:java.util.Locale):String ={
    val currency = java.util.Currency.getInstance(locale)
    currency.getSymbol(locale)
  }

  def pow(n:Long,m:Int):Long =
    if(m<=0) 1
    else pow(n,m-1) * n

}
