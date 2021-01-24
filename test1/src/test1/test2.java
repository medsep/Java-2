import java.util.ArrayList;

public class NoFilePenAdd extends Enquiry {

	@Override
	public List<String> setIds(List<FilterCriteria> filterCriteria, EnquiryContext enquiryContext) {
		NoFilePenDetails nofilepenDet = new NoFilePenDetails();
		EbPenNameDetailsNsbRecord ebpenRec = new EbPenNameDetailsNsbRecord(this);
		EbPenNameDetailsNsbTable ebpenTab = new EbPenNameDetailsNsbTable(this);

		DataAccess da = new DataAccess(this);

		String s2 = nofilepenDet.s3.toString();
		String s3 = filterCriteria.get(0).getValue(); /* will have the PEN Name */
		String s4 = filterCriteria.get(1).getValue(); /* will have the PEN Name */

		List<String> retId = new ArrayList<String>();
		TField accId = null;
		TField penId = null;
		TField mobId = null;

		EbPenNameDetailsNsbRecord accRec = new EbPenNameDetailsNsbRecord(da.getRecord("EB.PEN.NAME.DETAILS.NSB", s2));
		EbPenNameDetailsNsbRecord penRec = new EbPenNameDetailsNsbRecord(da.getRecord("EB.PEN.NAME.DETAILS.NSB", s3));
		EbPenNameDetailsNsbRecord mobRec = new EbPenNameDetailsNsbRecord(da.getRecord("EB.PEN.NAME.DETAILS.NSB", s4));

		accId = accRec.getId();
		penId = penRec.getPenName();
		mobId = mobRec.getMobileNo();

		/** if (accRec.equals(" ")) && (penId.equals(" ") && mobId.equals(" ")) { */

		if (accRec.equals(" ")) {

			ebpenRec.setPenName(s3);
			ebpenRec.setMobileNo(s4);
			try {
				ebpenTab.write(s3, ebpenRec);
				ebpenTab.write(s4, ebpenRec);
			} catch (Exception e) {
				throw new T24CoreException("", "Error");
			}

		} else {
			throw new Error("PEN Name Already Exists");

		}

		retId.add(s3);
		retId.add(s4);
		return retId;

	}
}