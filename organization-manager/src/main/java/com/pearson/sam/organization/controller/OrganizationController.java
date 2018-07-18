package com.pearson.sam.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.sam.organization.model.Organization;
import com.pearson.sam.organization.model.OrganizationResponse;
import com.pearson.sam.organization.service.OrganizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Organization Resource", description = "Organization")
@RequestMapping("/v1")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;

	@ApiOperation(value = "Health Check", notes = "Health Check")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@GetMapping
	public String getHealthStatus() throws Exception {
		return organizationService.getHealthStatus();
	}

	@ApiOperation(value = "Get Organization ", notes = "Get Organization Based On id")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@GetMapping("/{id}")
	public OrganizationResponse getOrganization(@PathVariable("id") String id) throws Exception {
		return organizationService.getOrganization(id);
	}

	@ApiOperation(value = "Create Organization", notes = "Create Organization")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@PostMapping()
	public OrganizationResponse createOrganization(@RequestBody Organization organization) throws Exception {
		return organizationService.createOrganization(organization);
	}

	@ApiOperation(value = "Update Organization", notes = "Update Organization Based On id")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@PutMapping("/{id}")
	public OrganizationResponse updateOrganization(@PathVariable("id") String id, @RequestBody Organization organization) throws Exception {
		return organizationService.updateOrganization(id, organization);
	}
}
