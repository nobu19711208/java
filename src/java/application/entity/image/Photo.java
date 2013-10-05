/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity.image;

import common.entity.SuperEntity;
import common.log.ApplicationLogger;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author nobuyuki
 */
@Named
//@ConversationScoped
@SessionScoped
@Entity
public class Photo extends SuperEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID=1L;

    /**
     *　Loggerを注入します
     */
    @Inject @Transient
    private transient ApplicationLogger logger;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="photoGen")
    @TableGenerator(name="photoGen", 
            table="SequenceNumber", 
            pkColumnName="name", 
            valueColumnName="number", 
            pkColumnValue="photoId", 
            allocationSize=1)
    private Long id;

    /**
     *
     */
    @Lob
    @Basic(fetch=FetchType.EAGER)
    private byte[] content;
    
    /**
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    /**
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    /**
     *
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     *
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    /**
     * @return the updateDate
     */
    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    @Override
    public void setUpdateDate(Date updateDate) {
        this.updateDate=updateDate;
    }

    /**
     * @return the registDate
     */
    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registDate the registDate to set
     */
    @Override
    public void setRegisterDate(Date registerDate) {
        this.registerDate=registerDate;
    }
}
