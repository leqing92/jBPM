package com.company.service.workitemhandler;

import org.jbpm.InsurerDetail;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.stereotype.Component;

@Component("MyTask")
public class MyTaskWorkItemHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println("\n\nWork item being executed " + workItem);
        InsurerDetail insurer = (InsurerDetail) workItem.getParameter("insurer");
        System.out.println("CustomWIH:" + insurer.getName());

        manager.completeWorkItem(workItem.getId(), null);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }

}
