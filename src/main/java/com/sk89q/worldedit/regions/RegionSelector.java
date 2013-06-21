// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldedit.regions;

import java.util.List;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.Vector;

/**
 * Region selection factory.
 */
public interface RegionSelector {
    
    /**
     * Called when the first point is selected.
     * 
     * @param pos the position
     * @return true if something changed
     */
    public boolean selectPrimary(Vector pos);

    /**
     * Called when the second point is selected.
     * 
     * @param pos the position
     * @return true if something changed
     */
    public boolean selectSecondary(Vector pos);

    /**
     * Tell the player information about his/her primary selection.
     * 
     * @param player the player
     * @param session the session
     * @param pos the position changed
     */
    public void explainPrimarySelection(LocalPlayer player,
            LocalSession session, Vector pos);

    /**
     * Tell the player information about his/her secondary selection.
     * 
     * @param player the player
     * @param session the session
     * @param pos the position changed
     */
    public void explainSecondarySelection(LocalPlayer player,
            LocalSession session, Vector pos);

    /**
     * The the player information about the region's changes. This may resend
     * all the defining region information if needed.
     * 
     * @param player the player
     * @param session the session
     */
    public void explainRegionAdjust(LocalPlayer player, LocalSession session);

    /**
     * Get the primary position.
     * 
     * @return the position
     * @throws IncompleteRegionException if a region has not been defined
     */
    public BlockVector getPrimaryPosition() throws IncompleteRegionException;

    /**
     * Get the selection.
     * 
     * @return the position
     * @throws IncompleteRegionException if a region has not been defined
     */
    public Region getRegion() throws IncompleteRegionException;

    /**
     * Get the region even if it's not fully defined.
     * 
     * @return the incomplete region
     */
    public Region getIncompleteRegion();

    /**
     * Returns whether the region has been fully defined.
     * 
     * @return true if fully defined
     */
    public boolean isDefined();

    /**
     * Get the number of blocks inside the region.
     * 
     * @return number of blocks or -1 if undefined
     */
    public int getArea();

    /**
     * Update the selector with changes to the region.
     */
    public void learnChanges();

    /**
     * Clear the selection.
     */
    public void clear();

    /**
     * Get a lowercase name of this region selector type.
     * 
     * @return the name
     */
    public String getTypeName();

    /**
     * Get lines of information about the selection.
     * 
     * @return the informational lines
     */
    public List<String> getInformationLines();
}
