package com.github.tadukoo.annotation.processor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.lang.model.element.Element;

import com.github.tadukoo.util.FileUtil;

/**
 * Annotation Processor for {@link AnnotationProcessor} annotation. Adds the classes with 
 * the annotation to the META-INF Annotation Processor file, and displays compilation errors 
 * on classes with the annotation that are not Annotation Processors (they must be a sub-class 
 * of {@link AbstractProcessor}).
 * 
 * @author Logan Ferree (Tadukoo)
 * @version Pre-Alpha
 */
public class AnnotationProcessorProcessor extends AbstractAnnotationProcessor{
	
	/**
	 * Constructor to designate this as an annotation processor for {@link AnnotationProcessor}.
	 */
	public AnnotationProcessorProcessor(){
		super(AnnotationProcessor.class);
	}
	
	/**
	 * Processes the {@link Element Elements} that include the {@link AnnotationProcessor} annotation. 
	 * Throws compilation errors on classes that aren't sub-classes of {@link AbstractProcessor} and 
	 * adds the others to the META-INF Annotation Processor file.
	 * 
	 * @param elements The Elements to process
	 */
	@Override
	protected void processElements(Set<? extends Element> elements) throws Throwable{
		// Grab the filename from AnnotationUtil
		String filename = AnnotationUtil.ANNOTATION_PROCESSOR_FILE;
		
		// Get a list of all the processors already in the file
		Set<String> processors;
		try{
			// Try to load from file
			processors = new HashSet<>(FileUtil.getLinesAsList(annotationUtil.getFileReader(filename)));
		}catch(IOException e){
			// If file loading fails, create empty Set
			processors = new HashSet<>();
		}
		
		// Process the elements
		for(Element element: elements){
			if(annotationUtil.isSubType(element, AbstractProcessor.class)){
				// If it's an annotation processor, add it to the list (in case it isn't already)
				processors.add(annotationUtil.getCanonicalClassName(element));
			}else{
				// If it's not an annotation processor, give a compilation error
				annotationUtil.displayCompileError(element, "This class must be a sub-class of AbstractProcessor!");
			}
		}
		
		// Write the new file contents to the file
		FileUtil.writeFile(annotationUtil.getFileWriter(filename), processors);
	}
}
