package de.gedoplan.buch.eedemos.jpa.repository;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.buch.eedemos.jpa.entity.Person;
import de.gedoplan.buch.eedemos.jpa.qualifier.ApplicationManaged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepositoryApplicationManagedEntityManager extends SingleIdEntityRepository<Integer, Person>
{
  private static final long serialVersionUID = 1L;

  @Override
  @Inject
  public void setEntityManager(@ApplicationManaged EntityManager entityManager)
  {
    super.setEntityManager(entityManager);
  }

  /**
   * Alle Änderungen abspeichern.
   */
  @Transactional
  public void saveAll()
  {
    // Ein Application Managed Entity Manager nimmt nicht automatisch an Transaktionen teil. Daher hier an TX anbinden. Ansonsten
    // würden Änderungen in den gemanagten Entities nicht in der DB abgelegt
    this.entityManager.joinTransaction();

    // Dies sollte eigentlich unnötig sein, da alle Änderungen ohnehin bei TX-Ende abgespeichert werden. Bei einigen
    // Server-Versionen war dies aber nicht der Fall, daher zur Sicherheit explizit aufrufen.
    this.entityManager.flush();
  }

}
