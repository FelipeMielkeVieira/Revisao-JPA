describe("Buscar Turma com Escola e Alunos", () => {
    it("Buscar Turma pelo ID junto com Escola e Alunos", () => {
        cy.request("GET", "http://localhost:8085/turma/1").as("BuscarTurmaComEscolaEAlunos");
        cy.get("@BuscarTurmaComEscolaEAlunos").then(response => {
            expect(response.body).to.have.property("listaDeAlunos");
            expect(response.body).to.have.property("escola");
        })
    })
})