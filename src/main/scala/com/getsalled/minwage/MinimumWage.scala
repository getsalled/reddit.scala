package com.getsalled.minwage

object MinimumWage {
	def applyAdjustments(beginning: Int, init_min_wage: Double) = {
		val wage_fmt = new java.text.DecimalFormat("#.00")
		val inc_fmt = new java.text.DecimalFormat("0.0")

		def dumpAdjustedWage(wage: Double, adj: Adjustment) = {
			val next_years_wage = wage * (1 + adj.increase / 100.0)
			println(s"${adj.year + 1} -> ${wage_fmt.format(next_years_wage)}")
			next_years_wage
		}

		println(s"$beginning -> $init_min_wage")

		CostOfLiving.increases .dropWhile( _.year < beginning) .foldLeft(init_min_wage)(dumpAdjustedWage)
	}

	// Source:  http://www.dol.gov/whd/minwage/chart.htm
	def adjustedFrom1978 = applyAdjustments(1978, 2.65)
	def adjustedFrom1979 = applyAdjustments(1979, 2.90)
	def adjustedFrom1980 = applyAdjustments(1980, 3.10)
	def adjustedFrom1981 = applyAdjustments(1981, 3.35)
	def adjustedFrom1990 = applyAdjustments(1990, 3.80)
	def adjustedFrom1991 = applyAdjustments(1991, 4.25)
	def adjustedFrom1996 = applyAdjustments(1996, 4.75)
	def adjustedFrom1997 = applyAdjustments(1997, 5.15)
	def adjustedFrom2007 = applyAdjustments(2007, 5.85)
	def adjustedFrom2008 = applyAdjustments(2008, 6.55)
	def adjustedFrom2009 = applyAdjustments(2009, 7.25)
}
