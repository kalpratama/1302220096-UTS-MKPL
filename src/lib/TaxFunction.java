package lib;

public class TaxFunction {
	private static final int BaseNonTaxedIncome = 54000000;
	private static final int SpouseAddition = 4500000;
	private static final int ChildAddition = 1500000;
	private static final int MaxChildren = 3;
	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(PersonDetails personDetails) {
		ValidateInputs(personDetails.getNumberOfChildren());
		
		int nonTaxedIncome = calculateNonTaxableIncome(family.isMarried(), family.getNumberOfChildren());
        int annualIncome = (employment.getMonthlySalary() + employment.getOtherMonthlyIncome()) * employment.getNumberOfMonthWorking();
        int taxableIncome = annualIncome - employment.getDeductible() - nonTaxedIncome;

        return computeTax(taxableIncome);

		private static void validateInputs(int monthsWorked, int numberOfChildren) {
			if (monthsWorked > 12) {
				throw new InvalidInputException("More than 12 months working per year.");
			}
	
			if (numberOfChildren > MaxChildren) {
				throw new InvalidInputException("Number of children exceeds allowed limit.");
			}
		}
	
		private static int calculateNonTaxedIncome(boolean isMarried, int numberOfChildren) {
			int nonTaxedIncome = BaseNonTaxedIncome;
	
			if (isMarried) {
				nonTaxedIncome += SpouseAddition;
			}
	
			nonTaxedIncome += Math.min(numberOfChildren, MaxChildren) * ChildAddition;
	
			return nonTaxedIncome;
		}
	
		private static int computeTax(int taxableIncome) {
			return taxableIncome > 0 ? (int) Math.round(taxableIncome * 0.05) : 0;
		}
	}
}
