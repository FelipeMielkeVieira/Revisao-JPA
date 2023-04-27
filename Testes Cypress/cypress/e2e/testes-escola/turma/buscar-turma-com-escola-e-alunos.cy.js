describe("Buscar Turma com Escola e Alunos", () => {
    it("Buscar Turma pelo ID junto com Escola e Alunos", () => {
        cy.request("GET", "http://localhost:8085/turma/5").as("BuscarTurmaComEscolaEAlunos");
        cy.get("@BuscarTurmaComEscolaEAlunos").then(response => {
            expect(response.body).to.have.property("listaDeAlunos").to.be.a("array");
            expect(response.body).to.have.property("escola");
        })
    })
})