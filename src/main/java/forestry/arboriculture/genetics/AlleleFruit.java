/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.arboriculture.genetics;

import forestry.api.arboriculture.IAlleleFruit;
import forestry.api.arboriculture.IFruitProvider;
import forestry.core.genetics.Allele;

public class AlleleFruit extends Allele implements IAlleleFruit {

	private final IFruitProvider provider;

	public AlleleFruit(String uid, IFruitProvider provider) {
		this(uid, provider, false);
	}

	public AlleleFruit(String uid, IFruitProvider provider, boolean isDominant) {
		super(uid, isDominant);
		this.provider = provider;
	}

	@Override
	public IFruitProvider getProvider() {
		return this.provider;
	}
	
	@Override
	public String getName() {
		return getProvider().getDescription();
	}

}
