package test.java.sacc;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import externalinterface.ExternalServiceProvider;
import externalinterface.SaccCommandDTO;
import externalinterface.ViolationImExportDTO;
import externalinterface.ViolationReportDTO;

public class SoftwareArchitectureComplianceCheck {
	public static final String EXPORT_FOLDER = "src/test/resources/sacc/export/";
	public static final String SACC_FOLDER = "src/test/resources/sacc/";

	// Refers to a files that contains the definition of the intended architecture (modules, rules, assigned software units, ...).
	private static final String workspacePath = SACC_FOLDER + "Game31_WorkspaceHUSACCT.xml";
	// Refers to a file containing a set of previous violations. Used to determine new violations.
	private static final String importFilePathAllPreviousViolations =
			SACC_FOLDER + "ArchitectureViolations_Game31_All_ImportFile.xml"; 

	private static SaccCommandDTO saccCommandDTO;
	private static ViolationReportDTO violationReport = null;


	@BeforeClass
	public static void beforeClass() {
		try {
			System.out.println(" Start SACC with HUSACCT on workspace: " + workspacePath);

			saccCommandDTO = new SaccCommandDTO();
			saccCommandDTO.setHusacctWorkspaceFile(workspacePath);
			ArrayList<String> paths = new ArrayList<>();
			paths.add("src/main");
			saccCommandDTO.setSourceCodePaths(paths);
			saccCommandDTO.setImportFilePreviousViolations(importFilePathAllPreviousViolations);
			saccCommandDTO.setExportAllViolations(true);
			saccCommandDTO.setExportNewViolations(false);
			
			ExternalServiceProvider externalServiceProvider = ExternalServiceProvider.getInstance();
			violationReport = externalServiceProvider.performSoftwareArchitectureComplianceCheck(saccCommandDTO);
		} catch (Exception e){
			String errorMessage =  "Exception: " + e.getCause().toString();
			System.out.println(errorMessage);
		}
	}

	@AfterClass
	public static void tearDown(){
		System.out.println(" Finished SACC with HUSACCT");
	}
	
	@Test
	public void hasNumberOfViolationsIncreased() {
		boolean numberOfViolationsHasNotIncreased = true;
		assertTrue(violationReport != null);
		if (violationReport != null) {
			System.out.println(" Previous number of violations: " + violationReport.getNrOfAllPreviousViolations() 
					+ "  At: " + getFormattedDate(violationReport.getTimePreviousCheck()));
			System.out.println(" Current number of violations: " + violationReport.getNrOfAllCurrentViolations());
			if (violationReport.getNrOfAllCurrentViolations() > violationReport.getNrOfAllPreviousViolations()) {
				numberOfViolationsHasNotIncreased = false;
			}
			/* Activate to renew the previous violations file. Only temporarily by one person, to prevent merging problems.  
			if (violationReport.getNrOfAllCurrentViolations() < violationReport.getNrOfAllPreviousViolations()) {
				replaceImportFileAllPreviousViolations();
			}
			*/
		}
		assertTrue(numberOfViolationsHasNotIncreased);
	}
	
	@SuppressWarnings("unused")
	private void replaceImportFileAllPreviousViolations() {
		if (importFilePathAllPreviousViolations != null) {
			File importFileAllPreviousViolations = new File(importFilePathAllPreviousViolations);
			if (violationReport.getExportDocAllViolations() != null) {
				if (importFileAllPreviousViolations.exists()) {
					try {
						importFileAllPreviousViolations.delete();
					} catch (SecurityException exception){
						System.out.println(" Cannot delete importFilePathAllPreviousViolations " + exception.getCause().toString());
					}
					// Create new importFileAllPreviousViolations with contents of exportFileAllViolations
					XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
					try {
						FileWriter fileWriter = new FileWriter(importFilePathAllPreviousViolations);
						outputter.output(violationReport.getExportDocAllViolations(), fileWriter);
						fileWriter.close();
					} catch (IOException exception){
						System.out.println(" Cannot create new importFilePathAllPreviousViolations " + exception.getCause().toString());
					}
					System.out.println(" Replaced: importFileAllPreviousViolations");
				}
			}
		}
	}


	@Test
	public void areNewArchitecturalViolationsDetected() {
		if (violationReport != null) {
			if (violationReport.getNrOfNewViolations() > 0) {
				System.out.println(" New architectural violations detected! Number of new violations = " + violationReport.getNrOfNewViolations());
				for (ViolationImExportDTO newViolation : violationReport.getNewViolations()) {
					//System.out.println(" Violation in class: " + newViolation.getFrom() + " Line: " + newViolation.getLine() + " Message: " + newViolation.getMessage());
				}
			} else {
				System.out.println(" No new architectural violations detected!");
			}
		}
	}
	
	
	private static String getFormattedDate(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		return dateFormat.format(calendar.getTime());
	}
}
