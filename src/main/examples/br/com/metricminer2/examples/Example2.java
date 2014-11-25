package br.com.metricminer2.examples;

import br.com.metricminer2.persistence.csv.CSVFile;
import br.com.metricminer2.scm.SourceCodeRepositoryStudy;
import br.com.metricminer2.scm.git.GitRepository;
import br.com.metricminer2.scm.metrics.cc.MethodLevelCyclomaticComplexity;
import br.com.metricminer2.scm.processor.MethodLevelMetricProcessor;

public class Example2 {


	public static void main(String[] args) {
		String repoPath = Example1.class.getResource("/repo-1/").getPath();
		String csvPath = Example1.class.getResource("/").getPath() + "cc.csv";
		
		new SourceCodeRepositoryStudy()
			.in(GitRepository.build(repoPath))
			.process(new MethodLevelMetricProcessor(new MethodLevelCyclomaticComplexity()), new CSVFile(csvPath))
			.start();
	}
}
