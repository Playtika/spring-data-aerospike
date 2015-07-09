/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.aerospike.repository.config;

import java.lang.annotation.Annotation;

import org.springframework.data.keyvalue.repository.config.KeyValueRepositoryConfigurationExtension;
import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

/**
 * Map specific {@link RepositoryBeanDefinitionRegistrarSupport} implementation.
 * 
 * @author Oliver Gierke
 */
public class AerospikeRepositoriesRegistrar extends RepositoryBeanDefinitionRegistrarSupport {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport#getAnnotation()
	 */
	@Override
	protected Class<? extends Annotation> getAnnotation() {
		return EnableAerospikeRepositories.class;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport#getExtension()
	 */
	@Override
	protected RepositoryConfigurationExtension getExtension() {
		return new AerospikeRepositoryConfigurationExtension();
	}

	/**
	 * {@link RepositoryConfigurationExtension} for Aerospike.
	 * 
	 * @author Oliver Gierke
	 */
	private static class AerospikeRepositoryConfigurationExtension extends KeyValueRepositoryConfigurationExtension {

		/*
		 * (non-Javadoc)
		 * @see org.springframework.data.keyvalue.repository.config.KeyValueRepositoryConfigurationExtension#getModuleName()
		 */
		@Override
		public String getModuleName() {
			return "Aerospike";
		}

		/*
		 * (non-Javadoc)
		 * @see org.springframework.data.keyvalue.repository.config.KeyValueRepositoryConfigurationExtension#getModulePrefix()
		 */
		@Override
		protected String getModulePrefix() {
			return "aerospike";
		}

		/* 
		 * (non-Javadoc)
		 * @see org.springframework.data.keyvalue.repository.config.KeyValueRepositoryConfigurationExtension#getDefaultKeyValueTemplateRef()
		 */
		@Override
		protected String getDefaultKeyValueTemplateRef() {
			return "aerospikeTemplate";
		}
	}
}