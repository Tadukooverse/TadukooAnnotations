# TadukooAnnotations
Tadukoo Annotations is a collection of annotations and utilities for creating annotations easier.

#### Table of Contents
* [Modules](#modules)
    * [Tadukoo Annotation Processor](#tadukoo-annotation-processor)
    * [Tadukoo Annotations](#tadukoo-annotations)
* [Current Plans](#current-plans)

## Modules

### Tadukoo Annotation Processor
Tadukoo Annotation Processor makes it easier to create annotation processors.

It contains the @AnnotationProcessor annotation, which should be used in annotation processors so they're properly added
to the META_INF services file. This annotation is handled by AnnotationProcessorProcessor, which just adds the canonical
class name to the META_INF/services/javax.annotation.processing.Processor file.

AbstractAnnotationProcessor should be extended by annotation processors you create. It handles the standard methods and
provides an instance of AnnotationUtil to make common functionality easier for processing annotations.

For more information on creating annotation processors using Tadukoo Annotation Processor, check out the
[Tadukoo Annotation Processor Guide](https://tadukooverse.github.io/guides/tadukoo-annotation-processor.html)

### Tadukoo Annotations
Tadukoo Annotations is a collection of annotations.

## Current Plans
Check out [the project page](https://tadukooverse.github.io/projects/TadukooAnnotations.html) for information about 
current plans for Tadukoo Annotations.