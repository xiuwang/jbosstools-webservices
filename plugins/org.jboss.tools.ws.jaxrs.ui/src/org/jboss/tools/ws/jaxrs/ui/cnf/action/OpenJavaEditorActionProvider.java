/******************************************************************************* 
 * Copyright (c) 2008 - 2014 Red Hat, Inc. and others. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Xavier Coulon - Initial API and implementation 
 ******************************************************************************/

package org.jboss.tools.ws.jaxrs.ui.cnf.action;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * @author xcoulon
 * 
 */
public class OpenJavaEditorActionProvider extends CommonActionProvider {

	private OpenJavaEditorAction openJavaEditorAction = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator
	 * .ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite aSite) {

		ICommonViewerSite viewSite = aSite.getViewSite();
		if (viewSite instanceof ICommonViewerWorkbenchSite) {
			openJavaEditorAction = new OpenJavaEditorAction();
			openJavaEditorAction.setSelection(aSite.getStructuredViewer().getSelection());
			aSite.getStructuredViewer().addSelectionChangedListener(openJavaEditorAction);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars
	 * )
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		// enables java editor opening on double-click
		actionBars.setGlobalActionHandler("org.jboss.tools.ws.jaxrs.ui.cnf.openJavaEditorActionProvider",
				openJavaEditorAction);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openJavaEditorAction);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.
	 * action.IMenuManager)
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		if (openJavaEditorAction != null && openJavaEditorAction.isEnabled()) {
			menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openJavaEditorAction);
		}
	}

}
