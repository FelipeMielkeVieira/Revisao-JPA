describe("Cadastrar turma com Alunos", () => {
    it("Cadastrar turma com Lista de Alunos", () => {
        cy.request("POST", "http://localhost:8085/turma", { nome: "Turma B", listaDeAlunos: [{ id: 1 }, { id: 2 }] }).as("CadastrarTurmaComAlunos");
        cy.get("@CadastrarTurmaComAlunos").then(response => {
            expect(response.body.listaDeAlunos).to.have.length.of.at.least(2);
        })
    })
})