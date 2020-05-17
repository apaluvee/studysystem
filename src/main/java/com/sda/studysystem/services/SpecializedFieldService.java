package com.sda.studysystem.services;


import com.sda.studysystem.models.SpecializedField;

import java.util.List;

/**
 * Service to handle SpecializedField related operations
 * @author Alar
 */

public interface SpecializedFieldService {

    /**
     * To create a new SpecializedField
     *
     * @param specializedField SpecializedField
     */
    boolean createSpecializedField(SpecializedField specializedField);

    /**
     * To update an existing SpecializedField
     *
     * @param specializedField specializedField
     * @return update result
     */
    boolean updateSpecializedField(SpecializedField specializedField);

    /**
     * To get a specializedField by its id
     *
     * @param specializedFieldId id of a specializedField
     * @return SpecializedField
     */
    SpecializedField getById(Long specializedFieldId);

    /**
     * To get all the SpecializedFields
     * @return list of all specializedFields
     */
    List<SpecializedField> getAllSpecializedFields();

    /**
     * To delete a specializedField (change active state)
     *
     * @param specializedFieldId specializedFieldId
     * @return is it deleted
     */
    boolean deleteSpecializedFieldById(Long specializedFieldId);

    /**
     * To restore a specializedField (change active state)
     *
     * @param specializedFieldId
     * @return
     */
    boolean restoreSpecializedFieldById(Long specializedFieldId);
}
