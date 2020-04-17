/*
 * Copyright (c) 2016 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import java.io.Serializable;
import java.util.Objects;

import org.dmg.pmml.Model;
import org.dmg.pmml.PMML;

public class ModelEvaluatorFactory extends ModelManagerFactory<ModelEvaluator<?>> implements Serializable {

	protected ModelEvaluatorFactory(){
		super((Class)ModelEvaluator.class);
	}

	public ModelEvaluator<?> newModelEvaluator(PMML pmml){
		return newModelEvaluator(pmml, (String)null);
	}

	public ModelEvaluator<?> newModelEvaluator(PMML pmml, String modelName){
		Objects.requireNonNull(pmml);

		Model model = PMMLUtil.findModel(pmml, modelName);

		return newModelEvaluator(pmml, model);
	}

	public ModelEvaluator<?> newModelEvaluator(PMML pmml, Model model){
		Objects.requireNonNull(pmml);
		Objects.requireNonNull(model);

		return newModelManager(pmml, model);
	}

	static
	public ModelEvaluatorFactory newInstance(){
		return new ModelEvaluatorFactory();
	}
}
