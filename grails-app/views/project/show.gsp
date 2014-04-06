
<%@ page import="org.octopus.Project" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="show-project" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list project">
			
				<g:if test="${projectInstance?.iid}">
				<li class="fieldcontain">
					<span id="iid-label" class="property-label"><g:message code="project.iid.label" default="Iid" /></span>
					
						<span class="property-value" aria-labelledby="iid-label"><g:fieldValue bean="${projectInstance}" field="iid"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="project.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${projectInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="project.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${projectInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.sampleType}">
				<li class="fieldcontain">
					<span id="sampleType-label" class="property-label"><g:message code="project.sampleType.label" default="Sample Type" /></span>
					
						<span class="property-value" aria-labelledby="sampleType-label"><g:fieldValue bean="${projectInstance}" field="sampleType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.sourceName}">
				<li class="fieldcontain">
					<span id="sourceName-label" class="property-label"><g:message code="project.sourceName.label" default="Source Name" /></span>
					
						<span class="property-value" aria-labelledby="sourceName-label"><g:fieldValue bean="${projectInstance}" field="sourceName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.organism}">
				<li class="fieldcontain">
					<span id="organism-label" class="property-label"><g:message code="project.organism.label" default="Organism" /></span>
					
						<span class="property-value" aria-labelledby="organism-label"><g:fieldValue bean="${projectInstance}" field="organism"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.characteristics}">
				<li class="fieldcontain">
					<span id="characteristics-label" class="property-label"><g:message code="project.characteristics.label" default="Characteristics" /></span>
					
						<span class="property-value" aria-labelledby="characteristics-label"><g:fieldValue bean="${projectInstance}" field="characteristics"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.treatmentProtocol}">
				<li class="fieldcontain">
					<span id="treatmentProtocol-label" class="property-label"><g:message code="project.treatmentProtocol.label" default="Treatment Protocol" /></span>
					
						<span class="property-value" aria-labelledby="treatmentProtocol-label"><g:fieldValue bean="${projectInstance}" field="treatmentProtocol"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.growthProtocol}">
				<li class="fieldcontain">
					<span id="growthProtocol-label" class="property-label"><g:message code="project.growthProtocol.label" default="Growth Protocol" /></span>
					
						<span class="property-value" aria-labelledby="growthProtocol-label"><g:fieldValue bean="${projectInstance}" field="growthProtocol"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.extractedMolecule}">
				<li class="fieldcontain">
					<span id="extractedMolecule-label" class="property-label"><g:message code="project.extractedMolecule.label" default="Extracted Molecule" /></span>
					
						<span class="property-value" aria-labelledby="extractedMolecule-label"><g:fieldValue bean="${projectInstance}" field="extractedMolecule"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.extractionProtocol}">
				<li class="fieldcontain">
					<span id="extractionProtocol-label" class="property-label"><g:message code="project.extractionProtocol.label" default="Extraction Protocol" /></span>
					
						<span class="property-value" aria-labelledby="extractionProtocol-label"><g:fieldValue bean="${projectInstance}" field="extractionProtocol"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.libraryStrategy}">
				<li class="fieldcontain">
					<span id="libraryStrategy-label" class="property-label"><g:message code="project.libraryStrategy.label" default="Library Strategy" /></span>
					
						<span class="property-value" aria-labelledby="libraryStrategy-label"><g:fieldValue bean="${projectInstance}" field="libraryStrategy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.librarySource}">
				<li class="fieldcontain">
					<span id="librarySource-label" class="property-label"><g:message code="project.librarySource.label" default="Library Source" /></span>
					
						<span class="property-value" aria-labelledby="librarySource-label"><g:fieldValue bean="${projectInstance}" field="librarySource"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.librarySelection}">
				<li class="fieldcontain">
					<span id="librarySelection-label" class="property-label"><g:message code="project.librarySelection.label" default="Library Selection" /></span>
					
						<span class="property-value" aria-labelledby="librarySelection-label"><g:fieldValue bean="${projectInstance}" field="librarySelection"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.instrumentModel}">
				<li class="fieldcontain">
					<span id="instrumentModel-label" class="property-label"><g:message code="project.instrumentModel.label" default="Instrument Model" /></span>
					
						<span class="property-value" aria-labelledby="instrumentModel-label"><g:fieldValue bean="${projectInstance}" field="instrumentModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="project.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${projectInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.dataProcessing}">
				<li class="fieldcontain">
					<span id="dataProcessing-label" class="property-label"><g:message code="project.dataProcessing.label" default="Data Processing" /></span>
					
						<span class="property-value" aria-labelledby="dataProcessing-label"><g:fieldValue bean="${projectInstance}" field="dataProcessing"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.lastUpdateDate}">
				<li class="fieldcontain">
					<span id="lastUpdateDate-label" class="property-label"><g:message code="project.lastUpdateDate.label" default="Last Update Date" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdateDate-label"><g:fieldValue bean="${projectInstance}" field="lastUpdateDate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.contactName}">
				<li class="fieldcontain">
					<span id="contactName-label" class="property-label"><g:message code="project.contactName.label" default="Contact Name" /></span>
					
						<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue bean="${projectInstance}" field="contactName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="project.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${projectInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.organizationName}">
				<li class="fieldcontain">
					<span id="organizationName-label" class="property-label"><g:message code="project.organizationName.label" default="Organization Name" /></span>
					
						<span class="property-value" aria-labelledby="organizationName-label"><g:fieldValue bean="${projectInstance}" field="organizationName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.department}">
				<li class="fieldcontain">
					<span id="department-label" class="property-label"><g:message code="project.department.label" default="Department" /></span>
					
						<span class="property-value" aria-labelledby="department-label"><g:fieldValue bean="${projectInstance}" field="department"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.lab}">
				<li class="fieldcontain">
					<span id="lab-label" class="property-label"><g:message code="project.lab.label" default="Lab" /></span>
					
						<span class="property-value" aria-labelledby="lab-label"><g:fieldValue bean="${projectInstance}" field="lab"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.streetAddress}">
				<li class="fieldcontain">
					<span id="streetAddress-label" class="property-label"><g:message code="project.streetAddress.label" default="Street Address" /></span>
					
						<span class="property-value" aria-labelledby="streetAddress-label"><g:fieldValue bean="${projectInstance}" field="streetAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="project.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${projectInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.zipPostalCode}">
				<li class="fieldcontain">
					<span id="zipPostalCode-label" class="property-label"><g:message code="project.zipPostalCode.label" default="Zip Postal Code" /></span>
					
						<span class="property-value" aria-labelledby="zipPostalCode-label"><g:fieldValue bean="${projectInstance}" field="zipPostalCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="project.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:fieldValue bean="${projectInstance}" field="country"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.sra}">
				<li class="fieldcontain">
					<span id="sra-label" class="property-label"><g:message code="project.sra.label" default="Sra" /></span>
					
						<span class="property-value" aria-labelledby="sra-label"><g:fieldValue bean="${projectInstance}" field="sra"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.bioSample}">
				<li class="fieldcontain">
					<span id="bioSample-label" class="property-label"><g:message code="project.bioSample.label" default="Bio Sample" /></span>
					
						<span class="property-value" aria-labelledby="bioSample-label"><g:fieldValue bean="${projectInstance}" field="bioSample"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.experimentType}">
				<li class="fieldcontain">
					<span id="experimentType-label" class="property-label"><g:message code="project.experimentType.label" default="Experiment Type" /></span>
					
						<span class="property-value" aria-labelledby="experimentType-label"><g:fieldValue bean="${projectInstance}" field="experimentType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.summary}">
				<li class="fieldcontain">
					<span id="summary-label" class="property-label"><g:message code="project.summary.label" default="Summary" /></span>
					
						<span class="property-value" aria-labelledby="summary-label"><g:fieldValue bean="${projectInstance}" field="summary"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.overallDesign}">
				<li class="fieldcontain">
					<span id="overallDesign-label" class="property-label"><g:message code="project.overallDesign.label" default="Overall Design" /></span>
					
						<span class="property-value" aria-labelledby="overallDesign-label"><g:fieldValue bean="${projectInstance}" field="overallDesign"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.submissionDate}">
				<li class="fieldcontain">
					<span id="submissionDate-label" class="property-label"><g:message code="project.submissionDate.label" default="Submission Date" /></span>
					
						<span class="property-value" aria-labelledby="submissionDate-label"><g:fieldValue bean="${projectInstance}" field="submissionDate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="project.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${projectInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.stateProvince}">
				<li class="fieldcontain">
					<span id="stateProvince-label" class="property-label"><g:message code="project.stateProvince.label" default="State Province" /></span>
					
						<span class="property-value" aria-labelledby="stateProvince-label"><g:fieldValue bean="${projectInstance}" field="stateProvince"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.platformId}">
				<li class="fieldcontain">
					<span id="platformId-label" class="property-label"><g:message code="project.platformId.label" default="Platform Id" /></span>
					
						<span class="property-value" aria-labelledby="platformId-label"><g:fieldValue bean="${projectInstance}" field="platformId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.supplementaryFiles}">
				<li class="fieldcontain">
					<span id="supplementaryFiles-label" class="property-label"><g:message code="project.supplementaryFiles.label" default="Supplementary Files" /></span>
					
						<g:each in="${projectInstance.supplementaryFiles}" var="s">
						<span class="property-value" aria-labelledby="supplementaryFiles-label"><g:link controller="supplementaryFile" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>
