package de.gedoplan.buch.eedemos.jpa.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = CocktailZutat.TABLE_NAME)
public class CocktailZutat
{
  public static final String TABLE_NAME = "EEDEMOS_COCKTAILZUTAT";

  @Id
  private String             id;

  private String             name;

  private double             volProz;

  public CocktailZutat(String id, String name, double volProz)
  {
    this.id = id;
    this.name = name;
    this.volProz = volProz;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public double getVolProz()
  {
    return this.volProz;
  }

  public void setVolProz(double volProz)
  {
    this.volProz = volProz;
  }

  @Override
  public int hashCode()
  {
    return this.id != null ? this.id.hashCode() : 0;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    final CocktailZutat other = (CocktailZutat) obj;

    return this.id != null && this.id.equals(other.id);
  }

  @Override
  public String toString()
  {
    return this.getClass().getSimpleName() + "{id=" + this.id + ",name=" + this.name + ",volProz=" + this.volProz + "}";
  }

  protected CocktailZutat()
  {
  }
}
