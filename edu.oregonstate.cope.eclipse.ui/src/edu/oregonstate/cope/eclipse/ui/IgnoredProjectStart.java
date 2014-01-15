package edu.oregonstate.cope.eclipse.ui;

import java.util.List;

import org.eclipse.ui.PlatformUI;

import edu.oregonstate.cope.eclipse.COPEPlugin;
import edu.oregonstate.cope.eclipse.InitializeWorkspaceOperation;
import edu.oregonstate.cope.eclipse.ui.handlers.ProjectSelectionDialog;

public class IgnoredProjectStart implements InitializeWorkspaceOperation {

	@Override
	public void doInit() {
		ProjectSelectionDialog projectSelectionDialog = 
				new ProjectSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						COPEPlugin.getDefault().getListOfWorkspaceProjects());
		projectSelectionDialog.open();
		List<String> ignoredProjects = projectSelectionDialog.getIgnoredProjects();
		StringBuffer value = new StringBuffer();
		for (String project : ignoredProjects) {
			value.append(project);
			value.append(";");
		}
		COPEPlugin.getDefault().getWorkspaceProperties().addProperty("ignoredProjects", value.toString());
	}

}
