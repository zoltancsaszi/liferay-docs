
package com.liferay.docs.guestbook.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.docs.guestbook.constants.GuestbookPortletKeys;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.EntryLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	immediate = true, 
	property = {
		"model.class.name=" + EntryPermission.RESOURCE_NAME
	}
)
public class EntryPermission implements BaseModelPermissionChecker {

	public static final String RESOURCE_NAME =
					"com.liferay.docs.guestbook.model.Entry";

	public static void check(
		PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}
	
	public static boolean contains(
		PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException, SystemException {

		Entry entry = _entryLocalService.getEntry(entryId);

		return contains(permissionChecker, entry, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Entry entry, String actionId) {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, entry.getGroupId(), Entry.class.getName(),
			entry.getEntryId(), GuestbookPortletKeys.GUESTBOOK, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(
			entry.getGroupId(), Entry.class.getName(), entry.getEntryId(),
			actionId);
	}

	@Reference(unbind = "-")
	protected void setEntryLocalService(
		EntryLocalService entryLocalService) {

		_entryLocalService = entryLocalService;
	}

	private static EntryLocalService _entryLocalService;
}
