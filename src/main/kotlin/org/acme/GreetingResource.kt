package org.acme

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.acme.repository.PersonRepository

/**
 * REST APIのエンドポイントになるクラス
 *
 * 各種Repositoryクラスをインジェクトして、CRUD操作を実装
 */
@Path("/")
class PersonResource {

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    fun hello() = "Hello from Quarkus REST"

    @Inject
    lateinit var personRepository: PersonRepository

    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPersons() = personRepository.listAll()

    @GET
    @Path("/persons/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPersonByName(@QueryParam("name") name:String) = personRepository.finByName(name)

    @GET
    @Path("/persons/alive")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAlivePersons() = personRepository.findAlive()

    @POST
    @Path("/persons/insert")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    fun insertStef() = personRepository.insertStef()

    @PUT
    @Path("/persons/update/put")
    @Produces(MediaType.APPLICATION_JSON)
    fun updateStefToStefan() = personRepository.updateStefToStefan()

    @PATCH
    @Path("/persons/update/patch")
    @Produces(MediaType.APPLICATION_JSON)
    fun patchStef() = personRepository.updateStefSatus()

    @DELETE
    @Path("/persons/delete")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteStefs() = personRepository.deleteStefs()

}