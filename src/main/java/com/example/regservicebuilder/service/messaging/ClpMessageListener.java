package com.example.regservicebuilder.service.messaging;

import com.example.regservicebuilder.service.ClpSerializer;
import com.example.regservicebuilder.service.DistrictLocalServiceUtil;
import com.example.regservicebuilder.service.DistrictServiceUtil;
import com.example.regservicebuilder.service.FarmerLocalServiceUtil;
import com.example.regservicebuilder.service.FarmerServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            DistrictLocalServiceUtil.clearService();

            DistrictServiceUtil.clearService();
            FarmerLocalServiceUtil.clearService();

            FarmerServiceUtil.clearService();
        }
    }
}
