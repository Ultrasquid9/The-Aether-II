package com.gildedgames.aether.common.world.island.logic;

public class IslandSector
{

	public final static int CHUNK_WIDTH_PER_SECTOR = 20;

	private final int sectorX, sectorY;

	private final long seed;

	private final IslandData[] data;

	public IslandSector(int sectorX, int sectorY, long seed, IslandData... data)
	{
		this.sectorX = sectorX;
		this.sectorY = sectorY;

		this.seed = seed;

		this.data = data;
	}

	public IslandData[] getAllIslandData()
	{
		return this.data;
	}

	public IslandData getIslandDataAtBlockPos(int x, int y)
	{
		for (IslandData data : this.data)
		{
			if (data != null && data.getBounds().intersects(x, y, 1, 1))
			{
				return data;
			}
		}

		return null;
	}

	public int getSectorX()
	{
		return this.sectorX;
	}

	public int getSectorY()
	{
		return this.sectorY;
	}

	public long getSeed()
	{
		return this.seed;
	}

}
