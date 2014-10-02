package ru.ulmc.extender.logic.model;

import net.minecraft.entity.player.EntityPlayer;
import ru.ulmc.extender.container.ContainerThief;

import java.util.Date;

/**
 * Created by 45 on 01.10.2014.
 */
public class StealModel {
	private static final int TIME_PER_STEP = 3000; //10 sec?
	private static final float PER_STEP_TIME_MODIFIER = 0.1f;
	private String thiefName;
	private String victimName;
	private int step;
	private int deltaTime;
	private Date approvedTime;
	private boolean isFailed;
	private EntityPlayer victim;
	private EntityPlayer thief;
	private ContainerThief container;

	public StealModel(EntityPlayer thief, EntityPlayer victim) {
		this.thief = thief;
		this.victim = victim;
		this.thiefName = thief.getDisplayName();
		this.victimName = victim.getDisplayName();
		this.step = 1;
	}

	public int setupToken() {
		deltaTime = Math.round(TIME_PER_STEP + TIME_PER_STEP * step * PER_STEP_TIME_MODIFIER);
		approvedTime = new Date(new Date().getTime() + deltaTime);
		return deltaTime;
	}

	public String getThiefName() {
		return thiefName;
	}

	public void setThiefName(String thiefName) {
		this.thiefName = thiefName;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public ContainerThief getContainer() {
		return container;
	}

	public void setContainer(ContainerThief container) {
		this.container = container;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Date getApprovedTime() {
		return approvedTime;
	}

	public void setApprovedTime(Date approvedTime) {
		this.approvedTime = approvedTime;
	}

	public boolean isFailed() {
		return isFailed;
	}

	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}

	public EntityPlayer getVictim() {
		return victim;
	}

	public void setVictim(EntityPlayer victim) {
		this.victim = victim;
	}

	public EntityPlayer getThief() {
		return thief;
	}

	public void setThief(EntityPlayer thief) {
		this.thief = thief;
	}
}
