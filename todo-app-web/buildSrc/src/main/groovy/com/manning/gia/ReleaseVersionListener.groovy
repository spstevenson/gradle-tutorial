package com.manning.gia

import org.gradle.api.Task
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.execution.TaskExecutionGraphListener
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.Project

class ReleaseVersionListener implements TaskExecutionGraphListener {
	final static String releaseTaskPath = ':release'
	
	@Override
	void graphPopulated(TaskExecutionGraph taskGraph) {
		if(taskGraph.hasTask(releaseTaskPath)) {
			List<Task> allTasks = taskGraph.allTasks
			Task releaseTask = allTasks.find { it.path == releaseTaskPath }
			Project project = releaseTask.project
			
			if(!project.version.release) {
				project.version.release = true
				project.ant.propertyfile(file: project.versionFile) {
					entry(key: 'release', type: 'string', operation: '=', value: 'true')
				}
			}
		}
	}
}