/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mnowrot.quicklist.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.mnowrot.quicklist.model.ListItem;
import org.mnowrot.quicklist.service.QuicklistService;

@Path("/")
public class QuicklistRestful {
    @EJB
    QuicklistService quicklistService;

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<ListItem> getAllItems() {
        return quicklistService.getAllItems();
    }
    
    @POST
    @Path("/add")
    public void addListItem(@FormParam("text") String text) {
        quicklistService.addListItem(text);
    }
}
