<%@ page import="org.octopus.Project" %>



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'iid', 'error')} ">
	<label for="iid">
		<g:message code="project.iid.label" default="GSM Number" />
		
	</label>
	<g:textField name="iid" value="${projectInstance?.iid}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="project.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${projectInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="project.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${projectInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'sampleType', 'error')} ">
	<label for="sampleType">
		<g:message code="project.sampleType.label" default="Sample Type" />
		
	</label>
	<g:textField name="sampleType" value="${projectInstance?.sampleType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'sourceName', 'error')} ">
	<label for="sourceName">
		<g:message code="project.sourceName.label" default="Source Name" />
		
	</label>
	<g:textField name="sourceName" value="${projectInstance?.sourceName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'organism', 'error')} ">
	<label for="organism">
		<g:message code="project.organism.label" default="Organism" />
		
	</label>
	<g:textField name="organism" value="${projectInstance?.organism}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'characteristics', 'error')} ">
	<label for="characteristics">
		<g:message code="project.characteristics.label" default="Characteristics" />
		
	</label>
	<g:textField name="characteristics" value="${projectInstance?.characteristics}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'treatmentProtocol', 'error')} ">
	<label for="treatmentProtocol">
		<g:message code="project.treatmentProtocol.label" default="Treatment Protocol" />
		
	</label>
	<g:textField name="treatmentProtocol" value="${projectInstance?.treatmentProtocol}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'growthProtocol', 'error')} ">
	<label for="growthProtocol">
		<g:message code="project.growthProtocol.label" default="Growth Protocol" />
		
	</label>
	<g:textField name="growthProtocol" value="${projectInstance?.growthProtocol}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'extractedMolecule', 'error')} ">
	<label for="extractedMolecule">
		<g:message code="project.extractedMolecule.label" default="Extracted Molecule" />
		
	</label>
	<g:textField name="extractedMolecule" value="${projectInstance?.extractedMolecule}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'extractionProtocol', 'error')} ">
	<label for="extractionProtocol">
		<g:message code="project.extractionProtocol.label" default="Extraction Protocol" />
		
	</label>
	<g:textField name="extractionProtocol" value="${projectInstance?.extractionProtocol}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'libraryStrategy', 'error')} ">
	<label for="libraryStrategy">
		<g:message code="project.libraryStrategy.label" default="Library Strategy" />
		
	</label>
	<g:textField name="libraryStrategy" value="${projectInstance?.libraryStrategy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'librarySource', 'error')} ">
	<label for="librarySource">
		<g:message code="project.librarySource.label" default="Library Source" />
		
	</label>
	<g:textField name="librarySource" value="${projectInstance?.librarySource}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'librarySelection', 'error')} ">
	<label for="librarySelection">
		<g:message code="project.librarySelection.label" default="Library Selection" />
		
	</label>
	<g:textField name="librarySelection" value="${projectInstance?.librarySelection}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'instrumentModel', 'error')} ">
	<label for="instrumentModel">
		<g:message code="project.instrumentModel.label" default="Instrument Model" />
		
	</label>
	<g:textField name="instrumentModel" value="${projectInstance?.instrumentModel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="project.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${projectInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'dataProcessing', 'error')} ">
	<label for="dataProcessing">
		<g:message code="project.dataProcessing.label" default="Data Processing" />
		
	</label>
	<g:textField name="dataProcessing" value="${projectInstance?.dataProcessing}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'lastUpdateDate', 'error')} ">
	<label for="lastUpdateDate">
		<g:message code="project.lastUpdateDate.label" default="Last Update Date" />
		
	</label>
	<g:textField name="lastUpdateDate" value="${projectInstance?.lastUpdateDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'contactName', 'error')} ">
	<label for="contactName">
		<g:message code="project.contactName.label" default="Contact Name" />
		
	</label>
	<g:textField name="contactName" value="${projectInstance?.contactName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="project.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${projectInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'organizationName', 'error')} ">
	<label for="organizationName">
		<g:message code="project.organizationName.label" default="Organization Name" />
		
	</label>
	<g:textField name="organizationName" value="${projectInstance?.organizationName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'department', 'error')} ">
	<label for="department">
		<g:message code="project.department.label" default="Department" />
		
	</label>
	<g:textField name="department" value="${projectInstance?.department}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'lab', 'error')} ">
	<label for="lab">
		<g:message code="project.lab.label" default="Lab" />
		
	</label>
	<g:textField name="lab" value="${projectInstance?.lab}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'streetAddress', 'error')} ">
	<label for="streetAddress">
		<g:message code="project.streetAddress.label" default="Street Address" />
		
	</label>
	<g:textField name="streetAddress" value="${projectInstance?.streetAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="project.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${projectInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'zipPostalCode', 'error')} ">
	<label for="zipPostalCode">
		<g:message code="project.zipPostalCode.label" default="Zip Postal Code" />
		
	</label>
	<g:textField name="zipPostalCode" value="${projectInstance?.zipPostalCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'country', 'error')} ">
	<label for="country">
		<g:message code="project.country.label" default="Country" />
		
	</label>
	<g:textField name="country" value="${projectInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'sra', 'error')} ">
	<label for="sra">
		<g:message code="project.sra.label" default="Sra" />
		
	</label>
	<g:textField name="sra" value="${projectInstance?.sra}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'bioSample', 'error')} ">
	<label for="bioSample">
		<g:message code="project.bioSample.label" default="Bio Sample" />
		
	</label>
	<g:textField name="bioSample" value="${projectInstance?.bioSample}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'experimentType', 'error')} ">
	<label for="experimentType">
		<g:message code="project.experimentType.label" default="Experiment Type" />
		
	</label>
	<g:textField name="experimentType" value="${projectInstance?.experimentType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="project.summary.label" default="Summary" />
		
	</label>
	<g:textField name="summary" value="${projectInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'overallDesign', 'error')} ">
	<label for="overallDesign">
		<g:message code="project.overallDesign.label" default="Overall Design" />
		
	</label>
	<g:textField name="overallDesign" value="${projectInstance?.overallDesign}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'submissionDate', 'error')} ">
	<label for="submissionDate">
		<g:message code="project.submissionDate.label" default="Submission Date" />
		
	</label>
	<g:textField name="submissionDate" value="${projectInstance?.submissionDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="project.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${projectInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'stateProvince', 'error')} ">
	<label for="stateProvince">
		<g:message code="project.stateProvince.label" default="State Province" />
		
	</label>
	<g:textField name="stateProvince" value="${projectInstance?.stateProvince}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'platformId', 'error')} ">
	<label for="platformId">
		<g:message code="project.platformId.label" default="Platform Id" />
		
	</label>
	<g:textField name="platformId" value="${projectInstance?.platformId}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'browsingStatus', 'error')} ">
	<label for="browsingStatus">
		<g:message code="project.browsingStatus.label" default="Browsing Status" />
		
	</label>
	<g:textField name="browsingStatus" value="${projectInstance?.browsingStatus}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'ucscFilePath', 'error')} ">
	<label for="ucscFilePath">
		<g:message code="project.ucscFilePath.label" default="Ucsc File Path" />
		
	</label>
	<g:textField name="ucscFilePath" value="${projectInstance?.ucscFilePath}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'tissue', 'error')} ">
	<label for="tissue">
		<g:message code="project.tissue.label" default="tissue" />
		
	</label>
	<g:textField name="tissue" value="${projectInstance?.tissue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'antibody', 'error')} ">
	<label for="antibody">
		<g:message code="project.antibody.label" default="antibody" />
		
	</label>
	<g:textField name="antibody" value="${projectInstance?.antibody}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'species', 'error')} ">
	<label for="species">
		<g:message code="project.species.label" default="species" />
		
	</label>
	<g:textField name="species" value="${projectInstance?.species}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'stage', 'error')} ">
	<label for="stage">
		<g:message code="project.stage.label" default="stage" />
		
	</label>
	<g:textField name="stage" value="${projectInstance?.stage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'treatment', 'error')} ">
	<label for="treatment">
		<g:message code="project.treatment.label" default="treatment" />
		
	</label>
	<g:textField name="treatment" value="${projectInstance?.treatment}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'supplementaryFiles', 'error')} ">
	<label for="supplementaryFiles">
		<g:message code="project.supplementaryFiles.label" default="Supplementary Files" />
		
	</label>
	<g:select name="supplementaryFiles" from="${org.octopus.SupplementaryFile.list()}" multiple="multiple" optionKey="id" size="5" value="${projectInstance?.supplementaryFiles*.id}" class="many-to-many"/>
</div>
